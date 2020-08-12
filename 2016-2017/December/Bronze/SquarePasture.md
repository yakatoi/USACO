Farmer John has decided to update his farm to simplify its geometry. Previously, his cows grazed in two rectangular fenced-in pastures. Farmer John would like to replace these with a single square fenced-in pasture of minimum size that still covers all the regions of his farm that were previously enclosed by the former two fences.
Please help Farmer John figure out the minimum area he needs to make his new square pasture so that if he places it appropriately, it can still cover all the area formerly covered by the two older rectangular pastures. The square pasture should have its sides parallel to the x and y axes.

INPUT FORMAT (file square.in):
The first line in the input file specifies one of the original rectangular pastures with four space-separated integers x1 y1 x2 y2, each in the range 0…10. The lower-left corner of the pasture is at the point (x1,y1), and the upper-right corner is at the point (x2,y2), where x2>x1 and y2>y1.
The second line of input has the same 4-integer format as the first line, and specifies the second original rectangular pasture. This pasture will not overlap or touch the first pasture.

OUTPUT FORMAT (file square.out):
The output should consist of one line containing the minimum area required of a square pasture that would cover all the regions originally enclosed by the two rectangular pastures.
SAMPLE INPUT:
6 6 8 8
1 8 4 9
SAMPLE OUTPUT:
49
In the example above, the first original rectangle has corners (6,6) and (8,8). The second has corners at (1,8) and (4,9). By drawing a square fence of side length 7 with corners (1,6) and (8,13), the original areas can still be enclosed; moreover, this is the best possible, since it is impossible to enclose the original areas with a square of side length only 6. Note that there are several different possible valid placements for the square of side length 7, as it could have been shifted vertically a bit.

Problem credits: Brian Dean