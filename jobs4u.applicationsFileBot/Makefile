CC=gcc
CFLAGS=-g -Wall # -Wextra -fanalyzer
SRC_DIR=src
OBJ_DIR=obj
BIN_DIR=bin
INCLUDE_DIR=include
TARGET=$(BIN_DIR)/main
SOURCES=$(shell find $(SRC_DIR) -name '*.c')
OBJECTS=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SOURCES))

.PHONY: all
all: setup clean $(TARGET) run

.PHONY: build
build: setup $(TARGET)

$(TARGET): $(OBJECTS)
	$(CC) $(CFLAGS) $^ -o $@

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c
	mkdir -p $(@D)
	$(CC) $(CFLAGS) -I $(INCLUDE_DIR) -c $< -o $@

.PHONY: clean
clean:
	find $(OBJ_DIR) -name '*.o' -delete
	rm -f $(TARGET)

.PHONY: run
run: $(TARGET)
	./$(TARGET)

.PHONY: setup
setup:
	mkdir -p $(OBJ_DIR) $(BIN_DIR)