# PatientManagementSystem
Midterm Sprint 

1. Why was a Queue appropriate for the waiting room?
A queue works like a real life line. The first person who shows up is the first person who gets helped, which keeps things fair and in order in a hospital waiting room.

2. Explain FIFO principle.
FIFO stands for First In, First Out. Whichever item or person goes in first is always the first one to come out.

3. Explain what could happen if a stack was used instead of a queue in Part 1.
A stack uses LIFO (Last In, First Out), meaning the last person to walk through the door would be treated first. If we used that in a hospital, patients who arrived early would have to wait forever while new patients kept cutting in front of them.

4. Suggest ways that you could improve this system (Theory).
We could add a priority queue so that people with severe injuries automatically jump ahead of routine checkups. We could also connect it to a real database so patient data doesn't disappear when the program closes.

5. Why is a Doubly Linked List appropriate for patient history?
It lets us easily step backward and forward through a patients past records. Each record has a link to both the one before it and the one after it, making navigation smooth.

6. What would happen in the DLL if you forgot to update the next and previous pointers when manipulating the DLL?
The chain would break. You would end up with broken links, which usually leads to errors or losing track of the records entirely.

7. Explain why a Doubly Linked List works in this case compared to an Array or Array List.
Arrays have a fixed size and require a lot of rearranging when you add things in the middle. A doubly linked list makes it so we dont have to worry about fixed storage size. 
