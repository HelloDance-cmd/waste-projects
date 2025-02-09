const http = require("http")

http.createServer((request, response) => {
    switch(request.url) {
        case "/":
            response.write('Hello');
            break;
        default:
            response.end("Page not found!");
    }
}).listen(8080, () => {
    console.log("Listener ");
    
});