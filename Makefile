TARGET = main/Main.java
SRC = src
BIN = bin

run: compile
	java -cp $(BIN) $(TARGET:%.java=%)

compile: $(BIN)/$(TARGET:%.java=%.class)

bin/%.class: src/%.java $(BIN)
	javac $< -d $(BIN) -cp $(SRC)

$(BIN):
	mkdir $(BIN)

clean:
	rm -rf $(BIN)

.PHONY: run compile clean
