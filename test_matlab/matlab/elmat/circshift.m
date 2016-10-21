%CIRCSHIFT Shift positions of elements circularly.
%   Y = CIRCSHIFT(X,K) where K is an integer scalar circularly shifts 
%   the elements in the array X by K positions along the first dimension. 
%   If K is positive, the values of X are shifted down. If it is negative, 
%   the values of X are shifted up.
%   
%   Y = CIRCSHIFT(X,K,DIM) circularly shifts along the dimension DIM.
%
%   Y = CIRCSHIFT(X,V) circularly shifts the values in the array X
%   by V elements. V is a vector of integers where the N-th element 
%   specifies the shift amount along the N-th dimension of
%   array X. 
%
%   Examples:
%      A = [ 1 2 3;4 5 6; 7 8 9];
%      B = circshift(A,1) % circularly shifts first dimension values down by 1.
%      B =     7     8     9
%              1     2     3
%              4     5     6
%      B = circshift(A,[1 -1]) % circularly shifts first dimension values
%                              % down by 1 and second dimension left by 1.
%      B =     8     9     7
%              2     3     1
%              5     6     4
%
%   See also FFTSHIFT, SHIFTDIM, PERMUTE.

%   Copyright 1984-2013 The MathWorks, Inc.
