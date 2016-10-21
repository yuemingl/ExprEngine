function t = trace(A), t = full(sum(diag(A))); end 
trace([1 2; 3 4])
