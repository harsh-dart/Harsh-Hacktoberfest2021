from hashlib import sha256
import random
import string
import time

def validate_hash(hash_, k):
	if not hash_: return False
	hash_number = int(hash_, 16)
	found = True

	# Check if the first k bits are 0
	for i in range(0, k):
		if hash_number & (1 << i):
			found = False
			break
	return found


def generate_salt(salt_size):
	# Generate random string with lowercase, uppercase and special characters
	options = string.ascii_letters + string.digits + string.punctuation
	return ''.join(random.choice(options) for i in range(salt_size))

def generate_hash(data, k, salt_size):
	count = 0
	hash_ = None

	while not validate_hash(hash_, k):
		count += 1
		salt = generate_salt(salt_size)
		data_with_salt = salt + data

		hash_ = sha256()
		hash_.update(bytes(data_with_salt, encoding='utf8'))
		hash_ = hash_.hexdigest()

	return hash_, count


if __name__ == '__main__':
	base_string = 'A base string for hash'
	salt_size = 5

	for k in range(1, 26):
		start_time = time.time()
		hash_, count = generate_hash(base_string, k, salt_size)
		end_time = time.time() - start_time

		print('Hash Generated - k: ' + str(k), end=' - ')
		print('Count: ' + str(count), end=' - ')
		print('Time spent: ' + str(end_time))
