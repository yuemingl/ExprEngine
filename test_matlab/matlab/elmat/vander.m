function A = vander(v)
%VANDER Vandermonde matrix.
%   A = VANDER(V) returns the Vandermonde matrix whose columns
%   are powers of the vector V, that is A(i,j) = v(i)^(n-j).
%
%   Class support for input V:
%      float: double, single

%   Copyright 1984-2014 The MathWorks, Inc. 

v = v(:);
n = length(v);
if n == 0
    A = reshape(v, n, n);
    return;
end
A = repmat(v, 1, n);
A(:, n) = 1;
A = cumprod(A, 2, 'reverse');

