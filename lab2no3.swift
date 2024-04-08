import Foundation

func checkTimeFormat(num: Int) -> Bool {
    if num < 100 {
        return false
    }
    
    let hours = num / 100
    let minutes = num % 100
    
    return (0...23).contains(hours) && (0...59).contains(minutes)
}

print("Enter the number of test cases:")
if let caseCount = readLine(), let count = Int(caseCount) {
    var i = 0
    while i < count {
        print("Enter time format (hhmm) or -1 to exit:")
        if let input = readLine(), let num = Int(input) {
            if num == -1 {
                break
            }
            
            if checkTimeFormat(num: num) {
                print("YES")
            } else {
                print("NO")
            }
            
            i += 1
        }
    }
}
