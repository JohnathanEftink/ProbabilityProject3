import matplotlib.pyplot as plot
import numpy as np

sizes = [10, 30, 50, 100, 250, 500, 1000]
xs = np.linspace(1,1000,200)
horiz_line_data = np.array([71.34 for i in range(len(xs))])
plot.plot(xs, horiz_line_data, 'r--')
for size in sizes:
    filename = "simdata" + str(size)
    file = open(filename)    
    #print(np.fromfile(file,dtype=float, sep=' ')[0])
    plot.plot([size]*111, np.fromfile(file,dtype=float, sep=' ',) "o")

plot.xlabel("Sample Size (n)")
plot.ylabel("Sample Mean (m_n)")
plot.title("Sample Mean v Sample Size")
plot.savefig("testgraph.png")

