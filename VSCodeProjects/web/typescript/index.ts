
export type Methods = "POST" | "PUT" | "GET";
export type Message = {
    type: Methods,
    content: any,
}

class URLRequest<T> {
    private url: T;
    private method: Methods;

    constructor(url: T, methods: Methods) {
        this.url = url;
        this.method = methods;
    }

    async send(msg: Message): Promise<any> {
        const response = await fetch("msg");
        await response.json();
        return response.text();
    }
}

const ur = new URLRequest<string>("http://www.baidu.com", "POST");
const rep = ur.send({
    type: "POST",
    content: "something"
})