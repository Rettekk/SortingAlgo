# SortingAlgo

Selectionsort:

Selectionsort ist ein Sortieralgorithmus, der ein Array oder eine Liste durchläuft, um das kleinste Element zu finden und an die erste Position zu setzen. Danach wird das nächste kleinste Element gesucht und an die zweite Position gesetzt und so weiter, bis alle Elemente sortiert sind.
Der Algorithmus funktioniert durch wiederholtes Durchlaufen der unsortierten Teilliste und Finden des kleinsten Elements in der Teilliste. Das gefundene Element wird dann an den Anfang der Teilliste verschoben und die Teilliste wird um das erste Element verkleinert. Dieser Prozess wird so lange wiederholt, bis die Teilliste nur noch aus einem Element besteht.

Bubblesort:
Bubblesort ist ein Sortieralgorithmus, der Elemente durch Vergleiche und Austausch in der Liste sortiert. Er arbeitet, indem er benachbarte Elemente in der Liste vergleicht und sie bei Bedarf austauscht.
Der Algorithmus durchläuft die Liste wiederholt, vergleicht jedes Paar benachbarter Elemente und tauscht sie bei Bedarf aus, um sicherzustellen, dass das größte Element nach jedem Durchlauf am Ende der Liste steht.
Dieser Prozess wird so lange wiederholt, bis keine weiteren Austausche erforderlich sind, d.h. die Liste vollständig sortiert ist.

Merge Sort:
Der Merge Sort Algorithmus sortiert ein Array durch rekursive Aufteilung in kleinere Teile und Zusammenführung dieser Teile in sortierter Reihenfolge. 
Hierzu wird das Array zunächst in zwei Hälften aufgeteilt, welche rekursiv sortiert werden. Anschließend werden die sortierten Teile zusammengeführt,
wobei die Elemente von beiden Seiten verglichen und in der korrekten Reihenfolge in das Ergebnis-Array eingefügt werden.

Quick Sort:
Der Quick Sort Algorithmus sortiert ein Array durch rekursive Aufteilung in kleinere Teile und partitioniert das Array um ein ausgewähltes Pivot-Element.
Die Elemente werden dabei so um das Pivot-Element herum aufgeteilt, dass alle Elemente auf der linken Seite kleiner und alle Elemente auf der rechten Seite größer als das Pivot-Element sind. 
Anschließend wird der Sortierprozess für die linke und rechte Partition rekursiv fortgesetzt, bis alle Elemente in der richtigen Reihenfolge sortiert sind.

Heap Sort:
Der Heap Sort Algorithmus sortiert ein Array durch Erstellen eines Max-Heaps, welcher die größten Elemente am Anfang des Arrays platziert. 
Hierzu wird das Array zunächst in einen Max-Heap umgewandelt, indem die Elemente des Arrays in einem Binärbaum angeordnet werden. 
Anschließend wird das Max-Element des Heaps an das Ende des Arrays verschoben und der Heap wird erneut gebaut, bis alle Elemente in sortierter Reihenfolge vorliegen.