export default function(mounted, count, template = {}) {
    const gap = count / 8 - 1;
    const {el = 'div', className = ''} = template
    for(let i = 0; i < count; i++) {
        if(i && i % 8 == 0)
            mounted.appendChild(createElement('div', 'ip-gap'))
        mounted.appendChild(createElement(el, className));
    }
}

function createElement(element, className = "") {
    const el = document.createElement(element);
    el.setAttribute('class', className);

    return el;
}