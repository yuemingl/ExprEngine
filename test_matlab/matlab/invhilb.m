function H = invhilb(n)
H = zeros(n);
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
//r=0.0;
//p=0.0;
end

invhilb(3)
