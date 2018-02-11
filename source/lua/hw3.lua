 function fromCSV (s)
      s = s .. '\t'        -- ending comma
      local t = {}        -- table to collect fields
      local fieldstart = 1
      repeat
        -- next field is quoted? (start with `"'?)
        if string.find(s, '^"', fieldstart) then
          local a, c
          local i  = fieldstart
          repeat
            -- find closing quote
            a, i, c = string.find(s, '"("?)', i+1)
          until c ~= '"'    -- quote not followed by quote?
          if not i then error('unmatched "') end
          local f = string.sub(s, fieldstart+1, i-1)
          table.insert(t, (string.gsub(f, '""', '"')))
          fieldstart = string.find(s, '\t', i) + 1
        else                -- unquoted; find next comma
          local nexti = string.find(s, '\t', fieldstart)
          table.insert(t, string.sub(s, fieldstart, nexti-1))
          fieldstart = nexti + 1
        end
      until fieldstart > string.len(s)
      return t
    end


f= io.open('turing.txt')
awards = {}
for line in f:lines() do
    table.insert(awards,fromCSV(line))
end


table.sort(awards,function (a,b) return a[4] < b[4] end)

for _,award in ipairs(awards) do
   print(award[1], award[2],award[3],award[4])
end
