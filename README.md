# PlotTest
 
XY chart example app.
For the X axis, this app obtains 100 random integers from a Rest API (JSON) and adds them to an A list, completing the list by adding 900 more random elements.
For the Y axis, the elements of list A are taken and a list B is created with the module 10 of its elements.
All the random integers are between 0 and 100.

Notes
List A is sorted for visual adapting.
At main branch we can observe that since we are generating 1000 elements, almost no variations are observed in the graph even if we change the data. 
This issue is resolved by generating just 100 (50 from API Rest and 50 locally) as seen in the Option B branch.
