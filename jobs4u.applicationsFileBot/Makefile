CC=gcc
CFLAGS=-g -Wall # -Wextra -fanalyzer
SRC_DIR=src
OBJ_DIR=obj
BIN_DIR=bin
INCLUDE_DIR=include
TARGET=$(BIN_DIR)/main
SOURCES=$(wildcard $(SRC_DIR)/*.c)
OBJECTS=$(SOURCES:$(SRC_DIR)/%.c=$(OBJ_DIR)/%.o)

.PHONY: all
all: setup clean $(TARGET) run

$(TARGET): $(OBJECTS)
	$(CC) $(CFLAGS) $^ -o $@

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c
	$(CC) $(CFLAGS) -I $(INCLUDE_DIR) -c $< -o $@

.PHONY: clean
clean:
	rm -f $(OBJ_DIR)/*.o $(TARGET)

.PHONY: run
run: $(TARGET)
	./$(TARGET)

.PHONY: setup
setup:
	mkdir -p $(OBJ_DIR) $(BIN_DIR)