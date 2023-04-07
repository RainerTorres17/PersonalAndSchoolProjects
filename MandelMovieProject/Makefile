
all: mandel

mandel: mandel.o bitmap.o
	gcc mandel.o bitmap.o -o mandel -lpthread

mandel.o: mandel.c
	gcc -Wall -g -c mandel.c -o mandel.o

mandelmovie: mandelmovie.c
	cc -Wall -o mandelmovie mandelmovie.c -lm

bitmap.o: bitmap.c
	gcc -Wall -g -c bitmap.c -o bitmap.o

clean:
	rm -f mandel.o bitmap.o mandel
