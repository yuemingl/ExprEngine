function H = hilb(n,classname)
%HILB   Hilbert matrix.
%   HILB(N) is the N by N matrix with elements 1/(i+j-1),
%   which is a famous example of a badly conditioned matrix.
%   See INVHILB for the exact inverse.
%
%   HILB(N,CLASSNAME) produces a matrix of class CLASSNAME.
%   CLASSNAME must be either 'single' or 'double' (the default).
%
%   This is also a good example of efficient MATLAB programming
%   style where conventional FOR or DO loops are replaced by
%   vectorized statements. 
%
%   See also INVHILB.

%   Copyright 1984-2013 The MathWorks, Inc.

if nargin < 2
   classname = 'double';
else  % nargin == 2
   if ~strcmpi(classname,'double') && ~strcmpi(classname,'single') 
      error(message('MATLAB:hilb:notSupportedClass'));
   end
end

J = 1:cast(n,classname);
H = 1./(bsxfun(@plus,J',J)-1);
