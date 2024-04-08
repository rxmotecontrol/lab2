def check_time_format(num)
  return false if num < 100
  hours = num / 100
  minutes = num % 100

  return (0..23).include?(hours) && (0..59).include?(minutes)
end

def main()
  puts "Enter the number of test cases: "
  case_count = gets.chomp.to_i
  i = 0

  while i < case_count
      puts "Enter time format (hhmm) or -1 to exit: "
      num = gets.chomp.to_i
      break if num == -1

      if check_time_format(num)
          puts "YES"
      else
          puts "NO"
      end

      i += 1
  end
end

if __FILE__ == $PROGRAM_NAME
  main()
end
