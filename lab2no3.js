function checkTimeFormat(num) {
    if (num < 100) {
        return false;
    }
    let hours = Math.floor(num / 100);
    let minutes = num % 100;

    if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
        return true;
    } else {
        return false;
    }
}

function main() {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question('Enter the number of test cases: ', (count) => {
        let caseCount = parseInt(count);
        let i = 0;

        rl.on('line', (input) => {
            let num = parseInt(input);
            if (num === -1) {
                rl.close();
                return;
            }
            if (checkTimeFormat(num)) {
                console.log("YES");
            } else {
                console.log("NO");
            }
            i++;
            if (i >= caseCount) {
                rl.close();
            }
        });
    });
}

main();
