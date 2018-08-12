package d_InterfaceSegregation.solution;

public class PDFFileProcessor implements ReadStream {
    @Override
    public String read() {
        return "This is the content of USS Discovery";
    }
}
