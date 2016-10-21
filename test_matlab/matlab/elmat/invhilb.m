function H = invhilb(n,classname)
%INVHILB Inverse Hilbert matrix.
%   INVHILB(N) is the inverse of the N by N matrix with elements
%   1/(i+j-1), which is a famous example of a badly conditioned
%   matrix.  The result is exact for  N  less than about 15.
%
%   INVHILB(N,CLASSNAME) produces a matrix of class CLASSNAME.
%   CLASSNAME must be either 'single' or 'double' (the default).
%
%   See also HILB.

%   Copyright 1984-2012 The MathWorks, Inc.

if nargin < 2
    classname = 'double';
end
H = zeros(n,classname);
p = n;
for i = 1:n
    r = p*p;
    H(i,i) = r/(2*i-1);
    for j = i+1:n
        r = -((n-j+1)*r*(n+j-1))/(j-1)^2;
        H(i,j) = r/(i+j-1);
        H(j,i) = r/(i+j-1);
    end
    p = ((n-i)*p*(n+i))/(i^2);
end

