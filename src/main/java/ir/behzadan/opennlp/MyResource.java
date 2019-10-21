// vim: foldmethod=syntax foldnestmax=2 foldenable
package ir.behzadan.opennlp;

import java.util.Arrays;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import opennlp.tools.util.Span;
import opennlp.tools.util.normalizer.EmojiCharSequenceNormalizer;


class Token {
    String body;
    String partOfSpeech;

    public void setBody(String body) { this.body = body; }
    public String getBody() { return body; }

    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }
    public String getPartOfSpeech() { return partOfSpeech; }

    @Override
    public String toString() {
        return "(" + body + ", "  + partOfSpeech + ")";
    }
}


class Sentence {
    String body;
    Token[] tokens;
    MySpan[] namedEntities;
    MySpan[] chunks;
    String[] parses;

    public void setBody(String body) { this.body = body; }
    public String getBody() { return body; }

    public void setTokens(Token[] tokens) { this.tokens = tokens; }
    public Token[] getTokens() { return tokens; }

    public void setNamedEntities(MySpan[] namedEntities) { this.namedEntities = namedEntities; }
    public MySpan[] getNamedEntities() { return namedEntities; }

    public void setChunks(MySpan[] chunks) { this.chunks = chunks; }
    public MySpan[] getChunks() { return chunks; }

    public void setParses(String[] parses) { this.parses = parses; }
    public String[] getParses() { return parses; }

    @Override
    public String toString() {
        String s = "";
        if (tokens.length > 0) {
            s += tokens[0].toString();
            for (int i=1;i<tokens.length;i++) {
                s += tokens[i].toString();
            }
        }
        return "Sent [" + s + "]";
    }
}


class Text {
    Sentence[] sentences;

    public void setSentences(Sentence[] sentences) { this.sentences = sentences; }
    public Sentence[] getSentences() { return sentences; }

    @Override
    public String toString() {
        return "Text " + Arrays.toString(sentences);
    }
}


class PipeLine {
    private OpenNLP engine;

    public PipeLine(OpenNLP engine) {
        this.engine = engine;
    }

    public Text run(String rawText) {
        rawText = this.normalizeEmoji(rawText);
        Text text = new Text();
        String[] sentences = engine.detectSentences(rawText);
        text.sentences = new Sentence[sentences.length];
        for (int i=0; i<sentences.length;i++) {
            Sentence sent = new Sentence();
            sent.body = sentences[i];
            String[] tokens = engine.tokenize(sent.body);
            String[] posTags = engine.tagPOS(tokens);
            sent.tokens = new Token[tokens.length];
            for(int j=0; j<tokens.length; j++) {
                sent.tokens[j] = new Token();
                sent.tokens[j].setBody(tokens[j]);
                sent.tokens[j].setPartOfSpeech(posTags[j]);
            }
            sent.namedEntities = engine.findNamedEntities(tokens);
            sent.chunks = engine.chunk(tokens, posTags);
            sent.parses = engine.parse(sent.body);
            text.sentences[i] = sent;
        }
        return text;
    }

    private String normalizeEmoji(String rawText) {
        return EmojiCharSequenceNormalizer.getInstance().normalize(rawText).toString();
    }
}


@Path("/")
public class MyResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Text parse(String rawText) {
        System.out.println("Text: " + rawText);
        OpenNLP nlp = OpenNLP.getInstance();
        PipeLine pipeline = new PipeLine(nlp);
        Text text = pipeline.run(rawText);
        return text;
    }
}
