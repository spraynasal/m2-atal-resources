package org.spraynasal.core.ex2;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public enum HashFunc {
    md5 {
        @Override
        public HashFunction getFunct() {
            return Hashing.md5();
        }
    }, sha1 {
        @Override
        public HashFunction getFunct() {
            return Hashing.sha1();
        }
    }, sha256 {
        @Override
        public HashFunction getFunct() {
            return Hashing.sha256();
        }
    }, crc32 {
        @Override
        public HashFunction getFunct() {
            return Hashing.crc32();
        }
    };

    public abstract HashFunction getFunct();
}
