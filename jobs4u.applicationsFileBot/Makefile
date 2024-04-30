CC=gcc
CFLAGS=-g -Wall # -Wextra -fanalyzer
OBJ_DIR=obj
BIN_DIR=bin
INCLUDE_DIR=include
TARGET=$(BIN_DIR)/main

# Compile sources
SRC_DIR=src
SOURCES=$(shell find $(SRC_DIR) -name '*.c')
OBJECTS=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SOURCES))

# Compile tests
TEST=test
TESTS=$(wildcard $(TEST)/*.c)
TESTS_BINS=$(patsubst $(TEST)/%.c,$(BIN_DIR)/%,$(TESTS))

# Compile benchmarks
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

.PHONY: test
test: $(TESTS_BINS)
	@for test in $(TESTS_BINS); do \
		./$$test; \
	done

.PHONY: run
run: $(TARGET)
	./$(TARGET)

.PHONY: setup
setup:
	mkdir -p $(OBJ_DIR) $(BIN_DIR)