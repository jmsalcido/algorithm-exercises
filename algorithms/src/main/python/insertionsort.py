#
# Insertion Sort - following the algorithm at Introduction to Algorithms
# Jose Salcido
#

# for any reason this shit is not sorting the first element.
def insertionsort(int_list):
    for j in range(1,len(int_list)):
        key = int_list[j]
        i = j - 1
        while i >= 0 and int_list[i] > key:
            int_list[i+1] = int_list[i]
            i = i-1
        int_list[i+1] = key


#def test():
    # lista = [5,2,4,6,1,3]
    # insertionsort(lista)
    # print lista
    # # output should be 1,2,3,4,5,6.