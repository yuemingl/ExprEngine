function GE(A)
  [m,n]=size(A);
  U=A;
  for j=1:n-1
    U(j+1:n,j)=(1/U(j,j))*U(j+1:n,j);
    for i=j+1:n
      U(i,j+1:n)=U(i,j+1:n)-U(i,j)*U(j,j+1:n);
    end
  end
  L=U-triu(U)+eye(n)
  U=triu(U)
end

GE([1 2 3; 4 5 6; 7 8 9]);
