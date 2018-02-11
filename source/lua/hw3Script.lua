os.execute("cp /afs/umbc.edu/users/b/w/bwilk1/pub/turing.txt .")

currentDirectory = os.getenv("PWD")
dofile(currentDirectory .. "/hw3.lua")
print("Question 1a (10 pts)")
io.write("pow(1,1) == 1 ^ 1: ")
if pcall(pow,1,1) then
  io.write(tostring(pow(1,1) == 1 ^ 1) .."\n")
else
  io.write("ERROR \n")
end

io.write("pow(1,100) == 1 ^ 100: ")
if pcall(pow,1,100) then
    io.write(tostring(pow(1,1) == 1 ^ 100).."\n")
else
  io.write("ERROR \n")
end

io.write("pow(2,2) == 2 ^ 2: ")
if pcall(pow,2,2) then
  io.write(tostring(pow(2,2) == 2 ^ 2) .. "\n")
else
  io.write("ERROR \n")
end

io.write("pow(10,10) == 10 ^ 10: ")
if pcall(pow,10,10) then
  io.write(tostring(pow(10,10) == 10 ^ 10) .. "\n")
else
  io.write("ERROR \n")
end

io.write("pow(7,7) == 7 ^ 7: ")
if pcall(pow,7,7) then
  io.write(tostring(pow(7,7) == 7 ^ 7) .. "\n")
else
  io.write("ERROR \n")
end
print("-----------------------------------------------")
print("")
print("Question 1b (10 pts)")

io.write("sigma({1,1,1,1}) == 4: ")
if pcall(sigma,{1,1,1,1}) then
  io.write(tostring(sigma({1,1,1,1}) == 4) .. "\n")
else
  io.write("ERROR \n")
end

io.write("sigma({1,2,3,4,5,6}) == 21: ")
if pcall(sigma,{1,2,3,4,5,6}) then
  io.write(tostring(sigma({1,2,3,4,5,6}) == 21) .. "\n")
else
  io.write("ERROR \n")
end

io.write("sigma({1,1.1,2,2.2,3,3.3}) == 12.6: ")
if pcall(sigma,{1,1.1,2,2.2,3,3.3}) then
  io.write(tostring(tonumber(string.format("%.1f",sigma({1,1.1,2,2.2,3,3.3}) or 0)) == 12.6) .. "\n")
else
  io.write("ERROR \n")
end

io.write("sigma({.1,.2,.3,.4,.5,.6}) == 2.1: ")
if pcall(sigma,{.1,.2,.3,.4,.5,.6}) then
  io.write(tostring(sigma({.1,.2,.3,.4,.5,.6}) == 2.1) .. "\n")
else
  io.write("ERROR \n")
end

print("------------------------------------------------")
print("")
print("Question 2a (10pts)")

io.write("longestString('dog','giraffe','bear','cat') == 'giraffe': ")
if pcall(longestString,'dog','giraffe','bear','cat') then
  io.write(tostring(longestString('dog','giraffe','bear','cat') == 'giraffe') .. "\n")
else
  io.write("ERROR \n")
end

io.write("longestString('dog','giraffe') == 'giraffe': ")
if pcall(longestString,'dog','giraffe') then
  io.write(tostring(longestString('dog','giraffe') == 'giraffe') .. "\n")
else
  io.write("ERROR \n")
end

io.write("longestString('dog','giraffe','bear') == 'giraffe': ")
if pcall(longestString,'dog','giraffe','bear') then
  io.write(tostring(longestString('dog','giraffe','bear') == 'giraffe') .. "\n")
else
  io.write("ERROR \n")
end

io.write("longestString('dog') == 'dog': ")
if pcall(longestString,'dog') then
  io.write(tostring(longestString('dog') == 'dog') .. "\n")
else
  io.write("ERROR \n")
end

io.write("longestString('bear','cat','dog') == 'bear': ")
if pcall(longestString,'bear','cat','dog') then
  io.write(tostring(longestString('bear','cat','dog') == 'bear') .. "\n")
else
  io.write("ERROR \n")
end


io.write("longestString('dog','giraffe','bear','elephant') == 'elephant': ")
if pcall(longestString,'dog','giraffe','bear','elephant') then
  io.write(tostring(longestString('dog','giraffe','bear','elephant') == 'elephant') .. "\n")
else
  io.write("ERROR \n")
end

print("------------------------------------------------")
print("")
print("Question 2b (10pts)")

pcall(function() x1,x2 = quadratic(1,-3,-4) end)
print("quadratic(1,-3,-4) == (1,-4): " .. tostring((x1 == -1 and x2 == 4) or (x1 == 4 and x2 == -1)))


pcall(function() y1,y2 = quadratic(1,0,-4) end)
print("quadratic(1,0,-4) == (2,-2): " .. tostring((y1 == 2 and y2 == -2) or (y1 == -2 and y2 == 2)))

pcall(function() z1,z2 = quadratic(1,2,-8) end)
print("quadratic(1,2,-8) == (-4,2): " .. tostring((z1 == -4 and z2 == 2) or (z1 == 2 and z2 == -4)))

pcall(function() a1,a2 = quadratic(2,7,3) end)
print("quadratic(2,7,3) == (-.5,-3): " ..tostring((a1 == -.5 and a2 == -3) or (a1 == -3 and a2 == -.5)))

pcall(function() b1,b2 = quadratic(1,12,36) end)
print("quadratic(1,12,36) == (-6,-6): " .. tostring(b1 == -6 and b2 == -6))
