import Foundation

var m = 0, n = 0
var mStart: Int? = nil
var nStart: Int? = nil

print("Enter m:")
if let mInput = readLine(), let mValue = Int(mInput) {
    m = mValue
}

print("Enter n:")
if let nInput = readLine(), let nValue = Int(nInput) {
    n = nValue
}

print("Enter line:")
if let line = readLine() {

    var mCurr = 1
    var nCurr = 1

    for i in line {
        switch i {
        case "L":
            mCurr -= 1
        case "R":
            mCurr += 1
        case "U":
            nCurr -= 1
        case "D":
            nCurr += 1
        default:
            break
        }
    }

    if m < 1 || n < 1 {
        print("Error")
    } else {
        if mCurr > m || nCurr > n {
            print("Error")
        } else if mCurr < 1 || nCurr < 1 {
            if mCurr < 1 {
                mStart = 2 + abs(mCurr)
            }
            if nCurr < 1 {
                nStart = 2 + abs(nCurr)
            }
            if let mStart = mStart, let nStart = nStart {
                print("\(mStart) \(nStart)")
            }
        } else {
            print("1 1")
        }
    }
}