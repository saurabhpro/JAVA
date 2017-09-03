1. If you want the following: 
    ```
    host/
    host/BaseServlet
    ```

    Use
    `@WebServlet({"/BaseServlet", ""})`

2. If you want the following:
    * `host`

    * Add this to your welcome file (you can't specify welcome files using annotations)
    ```xml
    <welcome-file-list>
       <welcome-file>/BaseServlet</welcome-file>
    </welcome-file-list>
    ```
    ~~~~java
    //The servlet spec says "A string containing only the '/' character indicates the "default" servlet of the application."

    //In this case the servlet path is the request URI minus the context path and the path info is null.
    ~~~~

3. In other words, if your URL is
    * `host`
    * then the servlet path will be

    * `"" (empty string)`
    * so you will need a welcome file list (but index.htm[l] and index.jsp in the webapp directory, not WEB-INF, are included implicitly as a starting welcome file list)