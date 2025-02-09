import elementGenerate from "./element-generate.js";
import recalculate from "./element-utils.js";

import { IPInputer } from "./element-utils.js";
import ipSelectAdd from "./ip-select-add.js";

const IP_BITS_COUNT = 32;
elementGenerate(document.querySelector(".ip-select"), IP_BITS_COUNT, { className: "ip-bits" }); 
const ipBits = document.querySelectorAll(".ip-select .ip-bits");

window.onload = () => recalculate(ipBits);
const ipInputer = new IPInputer(document.querySelector(".ip-select .ip-hover input"), ipBits, document.querySelector(".ip-select .ip-show span"))
window.ipInputer = ipInputer;

/**
 * IP 选择器功能
 */
ipBits.forEach(bits => (bits.innerHTML = 0));
ipBits.forEach(bits => {
    bits.addEventListener('click', (el) => {
        const bit = el.target;
        bit.innerHTML = Number(!(parseInt(bit.innerHTML)));
        recalculate(ipBits);
    });
})

/**
 * IP 选择器清除
 */
document.querySelector(".ip-select .ip-show button")?.addEventListener("click", () => {
    ipBits.forEach(bits => {
        bits.innerHTML = "0";
        recalculate(ipBits);
    });
})

document.querySelector(".add-ip-select").addEventListener("click", ipSelectAdd);