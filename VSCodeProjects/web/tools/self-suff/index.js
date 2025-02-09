/**
 * 
 * @param {number} x 
 * @param {number} n 
 */
function get_some_bits(x, n) {
    return x & ((1 << n) - 1);
}

/**
 * 
 * @param {number} x 
 * @param {number} x1 
 * @param {number} x2 
 * @returns {number}
 */
function get_some_bits_from_to(x, x1, x2) {
    if(x1 > x2)
        [x1, x2] = [x2, x1]
    const fill0_x1 = (1 << x1);
    const fill1_x2 = ((1 << (x2 + x1)) - 1);

    console.log(fill0_x1.toString(2));
    console.log(fill1_x2.toString(2));
    
    

    return (x & fill0_x1) & fill1_x2;
}


console.log(28 / [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3].length);
