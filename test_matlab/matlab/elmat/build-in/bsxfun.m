% BSXFUN  Binary Singleton Expansion Function
%   C = BSXFUN(FUNC,A,B) applies the element-by-element binary operation
%   specified by the function handle FUNC to arrays A and B, with singleton
%   expansion enabled. FUNC can be one of the following built-in functions:
%
%               @plus           Plus
%               @minus          Minus
%               @times          Array multiply
%               @rdivide        Right array divide
%               @ldivide        Left array divide
%               @power          Array power
%               @max            Binary maximum
%               @min            Binary minimum
%               @rem            Remainder after division
%               @mod            Modulus after division
%               @atan2	        Four-quadrant inverse tangent; result in radians
%               @atan2d	        Four-quadrant inverse tangent; result in dgrees
%               @hypot	        Square root of sum of squares
%               @eq             Equal
%               @ne             Not equal
%               @lt             Less than
%               @le             Less than or equal
%               @gt             Greater than
%               @ge             Greater than or equal
%               @and            Element-wise logical AND
%               @or             Element-wise logical OR
%               @xor            Logical EXCLUSIVE OR
%
%   FUNC can also be a handle to any binary element-wise function not listed
%   above. A binary element-wise function in the form of C = FUNC(A,B)
%   accepts arrays A and B of arbitrary but equal size and returns output
%   of the same size. Each element in the output array C is the result
%   of an operation on the corresponding elements of A and B only. FUNC must
%   also support scalar expansion, such that if A or B is a scalar, C is the
%   result of applying the scalar to every element in the other input array.
%
%   The corresponding dimensions of A and B must be equal to each other, or 
%   equal to one. Whenever a dimension of A or B is singleton (equal to 
%   one), BSXFUN virtually replicates the array along that dimension to 
%   match the other array. In the case where a dimension of A or B is 
%   singleton and the corresponding dimension in the other array is zero,
%   BSXFUN virtually diminishes the singleton dimension to zero.
%
%   The size of the output array C is equal to
%   max(size(A),size(B)).*(size(A)>0 & size(B)>0). For example, if
%   size(A) == [2 5 4] and size(B) == [2 1 4 3], then size(C) == [2 5 4 3].
%
%   Examples:
%
%   Subtract the column means from the matrix A:
%     A = magic(5);
%     A = bsxfun(@minus, A, mean(A));
%
%   Scale each row of A by its maximum absolute value:
%     A = rand(5);
%     A = bsxfun(@rdivide, A, max(abs(A),[],2));
%
%   Compute z(x, y) = x.*sin(y) on a grid:
%     x = 1:10;
%     y = x.';
%     z = bsxfun(@(x, y) x.*sin(y), x, y);
%
%   See also REPMAT, ARRAYFUN

%   Copyright 1984-2012 The MathWorks, Inc.
%   Built-in function.

