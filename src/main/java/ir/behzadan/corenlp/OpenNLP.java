// vim: foldmethod=syntax foldnestmax=2 foldenable
package ir.behzadan.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.util.Span;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.Parse;


public class OpenNLP {
    private static OpenNLP instance = null;
    public TokenizerME tokenizer = null;
    public SentenceDetectorME sentenceDetector = null;
    public POSTaggerME posTagger = null;
    public NameFinderME dateFinder = null;
    public NameFinderME locationFinder = null;
    public NameFinderME moneyFinder = null;
    public NameFinderME organizationFinder = null;
    public NameFinderME percentageFinder = null;
    public NameFinderME personFinder = null;
    public NameFinderME timeFinder = null;
    public Parser parser = null;
    public ChunkerME chunker = null;

    private void initSentenceDetector() {
        InputStream iStream;
        SentenceModel model = null;
        System.out.print("Loading Sentence-Detector model ... ");
        try {
            iStream = new FileInputStream("models/en-sent.bin");
            model = new SentenceModel(iStream);
            sentenceDetector = new SentenceDetectorME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            sentenceDetector = null;
            System.out.println("Failed!");
        }
    }

    private void initTokenizer() {
        InputStream modelIn;
        TokenizerModel tokenizerModel = null;
        System.out.print("Loading Tokenizer model ... ");
        try {
            modelIn = new FileInputStream("models/en-token.bin");
            tokenizerModel = new TokenizerModel(modelIn);
            tokenizer = new TokenizerME(tokenizerModel);
            System.out.println("Done!");
        }
        catch (IOException e) {
            tokenizer = null;
            System.out.println("Failed!");
        }
    }

    private void initPOSTagger() {
        InputStream iStream;
        POSModel model = null;
        System.out.print("Loading POS-Tagger model ... ");
        try {
            iStream = new FileInputStream("models/en-pos-maxent.bin");
            model = new POSModel(iStream);
            posTagger = new POSTaggerME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            posTagger = null;
            System.out.println("Failed!");
        }
    }

    private void initDateFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Date-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-date.bin");
            model = new TokenNameFinderModel(iStream);
            dateFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            dateFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initLocationFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Location-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-location.bin");
            model = new TokenNameFinderModel(iStream);
            locationFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            locationFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initMoneyFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Money-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-money.bin");
            model = new TokenNameFinderModel(iStream);
            moneyFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            moneyFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initOrganizationFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Organization-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-organization.bin");
            model = new TokenNameFinderModel(iStream);
            organizationFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            organizationFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initPercentageFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Percentage-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-person.bin");
            model = new TokenNameFinderModel(iStream);
            percentageFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            percentageFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initPersonFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Person-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-person.bin");
            model = new TokenNameFinderModel(iStream);
            personFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            personFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initTimeFinder() {
        InputStream iStream;
        TokenNameFinderModel model = null;
        System.out.print("Loading Time-Finder model ... ");
        try {
            iStream = new FileInputStream("models/en-ner-time.bin");
            model = new TokenNameFinderModel(iStream);
            timeFinder = new NameFinderME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            timeFinder = null;
            System.out.println("Failed!");
        }
    }

    private void initChunker() {
        InputStream iStream;
        ChunkerModel model = null;
        System.out.print("Loading Chunker model ... ");
        try {
            iStream = new FileInputStream("models/en-chunker.bin");
            model = new ChunkerModel(iStream);
            chunker = new ChunkerME(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            chunker = null;
            System.out.println("Failed!");
        }
    }

    private void initParser() {
        InputStream iStream;
        ParserModel model = null;
        System.out.print("Loading Parser model ... ");
        try {
            iStream = new FileInputStream("models/en-parser-chunking.bin");
            model = new ParserModel(iStream);
            parser = ParserFactory.create(model);
            System.out.println("Done!");
        }
        catch (IOException e) {
            parser = null;
            System.out.println("Failed!");
        }
    }

    private OpenNLP() {
        initSentenceDetector();
        initTokenizer();
        initPOSTagger();
        initDateFinder();
        initLocationFinder();
        initMoneyFinder();
        initOrganizationFinder();
        initPercentageFinder();
        initPersonFinder();
        initTimeFinder();
        initChunker();
        initParser();
    }

    public static OpenNLP getInstance() {
        if (instance == null) {
            instance = new OpenNLP();
        }
        return instance;
    }

    public String[] tokenize(String text) {
        return tokenizer.tokenize(text);
    }

    public String[] detectSentences(String text) {
        return sentenceDetector.sentDetect(text);
    }

    public String[] tagPOS(String[] tokens) {
        return posTagger.tag(tokens);
    }

    public MySpan[] findDate(String[] tokens) {
        return MySpan.spansToMySpans(dateFinder.find(tokens), tokens);
    }

    public MySpan[] findLocation(String[] tokens) {
        return MySpan.spansToMySpans(locationFinder.find(tokens), tokens);
    }

    public MySpan[] findMoney(String[] tokens) {
        return MySpan.spansToMySpans(moneyFinder.find(tokens), tokens);
    }

    public MySpan[] findOrganization(String[] tokens) {
        return MySpan.spansToMySpans(organizationFinder.find(tokens), tokens);
    }

    public MySpan[] findPercentage(String[] tokens) {
        return MySpan.spansToMySpans(percentageFinder.find(tokens), tokens);
    }

    public MySpan[] findPerson(String[] tokens) {
        return MySpan.spansToMySpans(personFinder.find(tokens), tokens);
    }

    public MySpan[] findTime(String[] tokens) {
        return MySpan.spansToMySpans(timeFinder.find(tokens), tokens);
    }

    public MySpan[] findNamedEntities(String[] tokens) {
        MySpan[] dates = findDate(tokens);
        MySpan[] locations = findLocation(tokens);
        MySpan[] moneys = findMoney(tokens);
        MySpan[] organizations = findOrganization(tokens);
        MySpan[] percentages = findPercentage(tokens);
        MySpan[] persons = findPerson(tokens);
        MySpan[] times = findTime(tokens);
        int len = dates.length + locations.length + moneys.length + times.length +
                  organizations.length + percentages.length + persons.length;
        MySpan[] namedEntities = new MySpan[len];
        int i = 0;
        for(MySpan span: dates)
            namedEntities[i++] = span;
        for(MySpan span: locations)
            namedEntities[i++] = span;
        for(MySpan span: moneys)
            namedEntities[i++] = span;
        for(MySpan span: organizations)
            namedEntities[i++] = span;
        for(MySpan span: percentages)
            namedEntities[i++] = span;
        for(MySpan span: persons)
            namedEntities[i++] = span;
        for(MySpan span: times)
            namedEntities[i++] = span;
        return namedEntities;
    }

    public MySpan[] chunk(String[] tokens, String[] tags) {
        return MySpan.spansToMySpans(chunker.chunkAsSpans(tokens, tags), tokens);
    }

    public String[] parse(String sentence) {
        Parse[] parses = ParserTool.parseLine(sentence, parser, 1);
        String[] parsesStr = new String[parses.length];
        int i = 0;
        for (Parse p: parses) {
            StringBuffer b = new StringBuffer();
            p.show(b);
            parsesStr[i++] = b.toString();
        }
        return parsesStr;
    }
}
