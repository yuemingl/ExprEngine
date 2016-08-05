function fib(r, n)
  A=[1 1; 1 0];
  if n<1
    r;
  else  
    r=A*r;
    fib(r, n-1);
  end
end

fib([1 1]', 5)
