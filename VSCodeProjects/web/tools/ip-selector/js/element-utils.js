export default function recalculate(ipBits) {
    const ipShow = document.querySelector(".ip-select .ip-show span");

    let bits = new Array(4).fill("").map(_ => "")
    for (let i = 0, j = 0; i < ipBits.length; i++) {
        if (i % 8 == 0 && i != 0)
            j++;
        bits[j] += ipBits[i].innerHTML;
    }

    // // 检查是否有误，临时代码
    // for(let bit of bits)
    //     console.log(bit.length, bit);

    const ipAddress = bits.map(bit => Number.parseInt(bit, 2))
        .reduce((p, c) => p.concat(c, "."), "").slice(0, -1);
    
    ipShow.innerHTML = ipAddress;
}

export class IPInputer {
    constructor(ipInput, ipBits, ipShow) {
        this.ipInput = ipInput;
        this.ipBits = ipBits;
        this.ipShow = ipShow;

        this.ipInput.addEventListener("change", (e) => this.updateIpAddress(e.target.value));
    }

    updateIpAddress(address) {
        address.split(".")
            .map(ip => Number.parseInt(ip).toString(2))
            .forEach((ip, idx) => {
                for(let i = 0; i < ip.length; i++) {
                    this.ipBits[idx * 8 + i].innerHTML = ip[i];
                }
            });
        
        this.ipInput.value = address;
        this.ipShow.innerHTML = address;
    }
}