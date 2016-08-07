A=[1 1; 1 0];
b=[1 1]';

tic
for i=1:46
  b=A*b;
end
toc

b
