function r=fib(n)
  if n<=1
    r=1L;
  else 
    r=fib(n-1)+fib(n-2);
  end
end

tic
fib(46)
toc

