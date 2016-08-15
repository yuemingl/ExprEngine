function [L U]=GE(A)
%
%  Compute Gaussian Elimination (GE) for A:  A=L*U. The code initially
%  set U=A and overwrite this U as going forward. Upon exit
%
%        U=triu(U)      is the U-factor
%        L=U-triu(U)+I  is the L-factor
%
%  No pivoting is done; so it may fail even A is very nonsingular, e.g., A=[0 1; 1 0].
%  It works surprisingly well for random matrices.
%
%                                RCL, 9/12/2012
%
%   Input
%           A   (n-by-n) matrix
%
%   Output

%           L   (n-by-n) matrix
%               the L-factor
%           U   (n-by-n) matrix
%               the U-factor
%
%
[m,n]=size(A);
if m ~=n,
   disp('GE: A must be a square matrix');
   return
end

U=A;
for j=1:n-1,
    U(j+1:n,j)=(1/U(j,j))*U(j+1:n,j);         % L(j+1:n,j)
    for i=j+1:n,         % elimination
        U(i,j+1:n)=U(i,j+1:n)-U(i,j)*U(j,j+1:n);
    end
end
L=U-triu(U)+eye(n); % or L=tril(U)-diag(diag(U))+eye(n);
U=triu(U);
end

GE([1 2 3; 4 5 6])
GE([1 2 3; 4 5 6; 7 8 9])

