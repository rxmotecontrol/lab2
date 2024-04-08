mStart = nil
nStart = nil

puts "Enter m:"
m = gets.to_i
puts "Enter n:"
n = gets.to_i
puts "Enter line:"
line = gets.chomp

mCurr = 1
nCurr = 1

if m < 1 or n < 1
puts "Error"
else
  line.each_char do |i|
    case i
    when 'L'  
      mCurr -= 1
    when 'R' 
      mCurr += 1
    when 'D' 
      nCurr += 1
    when 'U' 
      nCurr -= 1
    end
  end

if mCurr > m or nCurr > n
    puts "Error"
  elsif mCurr < 1 or nCurr < 1
    mStart = mCurr < 1 ? 2 + mCurr.abs : nil
    nStart = nCurr < 1 ? 2 + nCurr.abs : nil
    puts "#{mStart} #{nStart}"
  else
    puts "1 1"
  end
end
