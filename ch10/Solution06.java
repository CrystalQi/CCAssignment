/*
Since we cannot fit 20GB data into memory at the smae time,
considering the usual limitation on memory size.
So we need to load part of the data into memory,
eg: split the file into several chunks, each chunk being m MB, 
where m is the memory size.
Then we sort the data inside each chunk, then store the data 
back into the system.
After all the chunks are sorted, we combine them one after another,
and in the end, we get all the files sorted. 
This algorithm can be called "external sorting"


*/