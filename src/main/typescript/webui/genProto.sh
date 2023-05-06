OUTDIR=src/_proto
mkdir -p ${OUTDIR}
protoc \
	--proto_path=protos \
	--plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
	--plugin=protoc-gen-js=./node_modules/.bin/protoc-gen-js \
	--js_out=import_style=commonjs,binary:${OUTDIR} \
	--ts_out=service=grpc-web:${OUTDIR} \
	sudokubeRPC.proto