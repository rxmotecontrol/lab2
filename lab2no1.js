const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let m, n, mStart, nStart;
let line = '';

rl.question('Enter m: \n', (input) => {
    m = parseInt(input);
    rl.question('Enter n: \n', (input) => {
        n = parseInt(input);
        rl.question('Enter line: \n', (input) => {
            line = input.trim();
            
            let mCurr = 1, nCurr = 1;
            
            if (m < 1 || n < 1) {
                console.log("Error");
            } else {
                for (let i = 0; i < line.length; i++) {
                    switch (line[i]) {
                        case 'L':
                            mCurr -= 1;
                            break;
                        case 'R':
                            mCurr += 1;
                            break;
                        case 'D':
                            nCurr += 1;
                            break;
                        case 'U':
                            nCurr -= 1;
                            break;
                        default:
                            break;
                    }
                }

                if (mCurr > m || nCurr > n) {
                    console.log("Error");
                } else if (mCurr < 1 || nCurr < 1) {
                    if (mCurr < 1) {
                        mStart = 2 + Math.abs(mCurr);
                    }
                    if (nCurr < 1) {
                        nStart = 2 + Math.abs(nCurr);
                    }
                    console.log(mStart + ' ' + nStart);
                } else {
                    console.log("1 1");
                }
            }
            
            rl.close();
        });
    });
});
