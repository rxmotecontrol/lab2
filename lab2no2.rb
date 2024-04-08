def illustration(banki, ostatok, count_steps)
  if count_steps == 0
    puts "Jars"
    puts "F" * banki
  elsif count_steps.odd?
    puts "#{count_steps} step"
    puts "E" * banki
  else
    puts "#{count_steps} step"
    puts "F" * (banki - ostatok)
    puts "E" * ostatok
  end
end

puts "Input jar quantity: "
banki = gets.chomp.to_i
puts "Input exchange: "
obmen = gets.chomp.to_i

if banki <= 0 || obmen <= 0
  puts "Error"
else
  count_empty = 0
  count_steps = 0
  ostatok = 0
  new_banki = banki

  while new_banki >= obmen
    if count_steps == 0
      illustration(new_banki, ostatok, count_steps)
    end
    count_steps += 1
    illustration(new_banki, ostatok, count_steps)
    count_empty += new_banki - ostatok
    ostatok = new_banki % obmen
    new_banki = (new_banki / obmen) + ostatok
    count_steps += 1
    illustration(new_banki, ostatok, count_steps)
  end

  if new_banki < obmen
    count_empty += new_banki - ostatok
    count_steps += 1
    illustration(new_banki, ostatok, count_steps)
    puts "Jars drunk: #{count_empty}"
    puts "Step count: #{count_steps}"
  end
end
