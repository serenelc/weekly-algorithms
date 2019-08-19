'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(str => str.trim());

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the cookies function below.
 */
function cookies(k, A) {
    let numOperations = 0;
    let i = 0;
    A.sort((a, b) => a - b);

    while (A[i] < k) {
        if (A.length === 1) {
            numOperations = -1;
            break;
        }

        let temp = A[i] + (2 * A[i + 1]);
        A.push(temp);
        A.splice(i, 2);
        A.sort((a, b) => a - b );
        console.log(A);
        numOperations++;
    }

    if (A.length === 0) {
        numOperations = -1;
    }

    return numOperations;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    const A = readLine().split(' ').map(ATemp => parseInt(ATemp, 10));

    let result = cookies(k, A);

    ws.write(result + "\n");

    ws.end();
}
