# Multiplication calculator for big number
Program works with expected number of arguments provided (2 or 3) from command line. First argument is providing information, which algorithm to use
<ol>
  <li>for using "BigInt" implementation use arg <b>--bi</b></li>
  <li>for using "CustomNumber" implementation use arg <b>--cn</b></li>
  <li>no arg provided, then is automatically used "BigInt" implementation</li>
</ol>
Next two args, which are provided are numbers, which will be used for multiplication.
<br>
<b>Example</b>:
<ol>
  <li>--bi 12345678901234567890 11111111111111111111</li>
  <li>--cn 12345678901234567890 11111111111111111111</li>
  <li>12345678901234567890 11111111111111111111</li>
</ol>
Result will be for all options the same: 137174210013717420998628257899862825790
