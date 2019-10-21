// vim: foldmethod=syntax foldnestmax=2 foldenable
package ir.behzadan.opennlp;

import opennlp.tools.util.Span;


public class MySpan {
    String body;
    String label;
    int start;
    int end;

    public void setBody(String body) { this.body = body; }
    public String getBody() { return body; }

    public void setLabel(String label) { this.label = label; }
    public String getLabel() { return label; }

    public void setStart(int start) { this.start = start; }
    public int getStart() { return start; }

    public void setEnd(int end) { this.end = end; }
    public int getEnd() { return end; }

    static MySpan spanToMySpan(Span span, String[] tokens) {
        MySpan mySpan = new MySpan();
        int start = span.getStart();
        int end = span.getEnd();
        String body = "";
        mySpan.setStart(start);
        mySpan.setEnd(end);
        mySpan.setLabel(span.getType());
        for(int i=start; i<end; i++)
            body += tokens[i] + " ";
        mySpan.body = body.trim();
        return mySpan;
    }

    static MySpan[] spansToMySpans(Span[] spans, String[] tokens) {
        int start;
        int end;
        int i = 0;
        String body;
        MySpan mySpan;
        MySpan[] mySpans = new MySpan[spans.length];

        for (Span span: spans) {
            mySpan = new MySpan();
            start = span.getStart();
            end = span.getEnd();
            body = "";
            mySpan.setStart(start);
            mySpan.setEnd(end);
            mySpan.setLabel(span.getType());
            for(int j=start; j<end; j++)
                body += tokens[j] + " ";
            mySpan.body = body.trim();
            mySpans[i++] = mySpan;
        }
        return mySpans;
    }
}
