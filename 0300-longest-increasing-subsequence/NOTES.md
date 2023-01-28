Arrays.binarySearch - > java
Return Type: index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
idx = -idx as the element to be found is not present.
idx-1 = index of just greater element
lower_bound -> cpp
The lower_bound() method in C++ is used to return an iterator pointing to the first element in the range [first, last) which has a value not less than val. This means that the function returns an iterator pointing to the next smallest number just greater than or equal to that number