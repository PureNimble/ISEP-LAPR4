CC=gcc
CFLAGS=-g -Wall # -Wextra -fanalyzer
OBJ_DIR=obj/main
OBJ_DIR_TEST=obj/test
BIN_DIR=bin
INCLUDE_DIR=include
MAIN_FILE = main
TEST_FILE = test
TARGET=$(BIN_DIR)/$(MAIN_FILE)
TEST_TARGET=$(BIN_DIR)/$(TEST_FILE)

# Compile sources
SRC_DIR=src
MAIN_SOURCES=$(shell find $(SRC_DIR)/main -name '*.c')
TEST_SOURCES=$(shell find $(SRC_DIR)/test -name '*.c')
MAIN_OBJECTS=$(patsubst $(SRC_DIR)/main/%.c,$(OBJ_DIR)/%.o,$(MAIN_SOURCES))
TEST_OBJECTS=$(patsubst $(SRC_DIR)/test/%.c,$(OBJ_DIR_TEST)/%.o,$(TEST_SOURCES))

# Compile benchmarks
.PHONY: all
all: setup clean $(TARGET) run

.PHONY: build
build: setup $(TARGET)

# Create the main target
$(TARGET): $(MAIN_OBJECTS)
	$(CC) $(CFLAGS) $^ -o $@

# Compile
$(OBJ_DIR)/%.o: $(SRC_DIR)/main/%.c
	mkdir -p $(@D)
	$(CC) $(CFLAGS) -I $(INCLUDE_DIR) -c $< -o $@

$(OBJ_DIR_TEST)/%.o: $(SRC_DIR)/test/%.c
	mkdir -p $(@D)
	$(CC) $(CFLAGS) -I $(INCLUDE_DIR) -c $< -o $@

# Create the test target
$(TEST_TARGET): $(TEST_OBJECTS) $(filter-out $(OBJ_DIR)/main.o, $(MAIN_OBJECTS))
	$(CC) $(CFLAGS) -DTEST $^ -o $@

.PHONY: clean
clean:
	find $(OBJ_DIR) -name '*.o' -delete
	rm -f $(TARGET) $(TEST_TARGET)

.PHONY: run
run: $(TARGET)
	./$(TARGET)

.PHONY: test 
test: setup clean $(TEST_TARGET)
	./$(TEST_TARGET)

.PHONY: setup
setup:
	mkdir -p $(OBJ_DIR) $(BIN_DIR)