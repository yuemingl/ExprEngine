function r=fib(n, r)
  A=[1 1; 1 0];
  if n<1
    r;
  else  
    r=A*r;
    r=fib(n-1, r);
  end
end

fib(42, [1 1]')
