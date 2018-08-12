package d_InterfaceSegregation.solution;

interface Stream extends ReadStream, WriteStream {
}

interface ReadStream {
    String read();
}

interface WriteStream {
    void write(String data);
}

