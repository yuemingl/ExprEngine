function r=fib(n)
  if n<=1
    r=1;
  else 
    r=fib(n-1)+fib(n-2);
  end
end

fib(5)

