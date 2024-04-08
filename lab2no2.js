function illustration(banki, ostatok, countSteps) {
    if (countSteps === 0) {
        console.log("Jars");
        console.log("F".repeat(banki));
    } else if (countSteps % 2 !== 0) {
        console.log("E".repeat(banki));
    } else {
        console.log("F".repeat(banki - ostatok));
        console.log("E".repeat(ostatok));
    }
}

function main() {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("Input jar quantity: ", function(banki) {
        rl.question("Input exchange: ", function(obmen) {
            banki = parseInt(banki);
            obmen = parseInt(obmen);

            if (banki <= 0 || obmen <= 0) {
                console.log("Error");
            } else {
                let countEmpty = 0;
                let countSteps = 0;
                let ostatok = 0;
                let newBanki = banki;

                while (newBanki >= obmen) {
                    if (countSteps === 0) {
                        illustration(newBanki, ostatok, countSteps);
                    }
                    countSteps++;
                    illustration(newBanki, ostatok, countSteps);
                    countEmpty += newBanki - ostatok;
                    ostatok = newBanki % obmen;
                    newBanki = Math.floor(newBanki / obmen) + ostatok;
                    countSteps++;
                    illustration(newBanki, ostatok, countSteps);
                }

                if (newBanki < obmen) {
                    countEmpty += newBanki - ostatok;
                    countSteps++;
                    illustration(newBanki, ostatok, countSteps);
                    console.log(countEmpty);
                    console.log(countSteps);
                }
            }

            rl.close();
        });
    });
}

main();
